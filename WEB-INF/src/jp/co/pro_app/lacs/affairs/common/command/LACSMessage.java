package jp.co.pro_app.lacs.affairs.common.command;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import jp.co.pro_app.lacs.affairs.common.data.entity.LACSMessageEntity;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * メッセージ編集.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSMessage {
	private ArrayList<Object>			messages	= new ArrayList<Object>();	// メッセージ

	private Connection			con			= null;			// DB接続

	private DBModelBase			model		= null;

	/**
	 * ログインエラー.
	 */
	public static final String	ERR_LOGIN	= "EWD003";

	/**
	 * メッセージの有無を取得.
	 * 
	 * @return メッセージの有無(true：有り／false：無し)
	 */
	public boolean hasMessage() {
		return messages.size() != 0;
	}

	/**
	 * コンストラクタ(シングルトン).
	 * 
	 * @param piModel
	 *            モデル
	 * @param piCon
	 *            DB接続
	 * @return メッセージオブジェクト
	 */
	public static LACSMessage createLACSMessage(DBModelBase piModel, Connection piCon) {
		return new LACSMessage(piModel, piCon);
	}

	private LACSMessage(DBModelBase piModel, Connection piCon) {
		this.model = piModel;
		this.con = piCon;
	}

	/**
	 * メッセージを追加.
	 * 
	 * @param piMessageID
	 *            メッセージID
	 * @param piText
	 *            置き換え文字
	 */
	public void addMessage(String piMessageID, String[] piText) {
		this.messages.add(new MessageInfo(piMessageID, piText));
	}

	/**
	 * メッセージを追加.
	 * 
	 * @param piMessageID
	 *            メッセージID
	 */
	public void addMessage(String piMessageID) {
		this.messages.add(new MessageInfo(piMessageID));
	}

	/**
	 * メッセージを追加.
	 * 
	 * @param piMessageID
	 *            メッセージID
	 * @param piText
	 *            置き換え文字
	 */
	public void addMessage(String piMessageID, String piText) {
		this.messages.add(new MessageInfo(piMessageID, piText));
	}

	/**
	 * メッセージを取得.
	 * 
	 * @return メッセージ
	 * @throws SQLException
	 *             SQL実行例外
	 */
	public String getMessage() throws SQLException {
		StringBuffer buf = new StringBuffer();
		MessageInfo info = null;
		String text = null;
		LACSMessageEntity entity = new LACSMessageEntity(this.model);
		StringBuffer temp = new StringBuffer();
		String mark = "";
		int pos = 0;

		try {

			entity.setCon(this.con);

			if (this.messages.size() > 0) {

				buf.append("<UL class=\"font-red font-14\"> " + "\n");

				for (int i = 0; i < this.messages.size(); i++) {

					info = (MessageInfo)this.messages.get(i);

					entity.setMessageCode(info.messageID);
					entity.execSQL();

					buf.append("<LI>");
					if (entity.next()) {

						temp = new StringBuffer(entity.getMessage());

						for (int j = 0; j < info.getText().size(); j++) {
							text = (String)info.getText().get(j);
							mark = "?<" + j + ">?";
							pos = temp.indexOf(mark);

							temp.replace(pos, pos + mark.length(), text);
						}

						buf.append(temp.toString());

					}
					else {
						buf.append("メッセージIDが設定されていません：" + info.messageID);
					}

					buf.append("</LI> " + "\n");
				}

				buf.append("</UL> " + "\n");
			}
		}
		finally {
			entity.close();
		}
		return buf.toString();
	}

	/**
	 * メッセージ情報.
	 * 
	 * @author katoken
	 * @version 20070312
	 */
	private class MessageInfo {
		private String		messageID	= "";				// メッセージID

		private ArrayList<Object>	text		= new ArrayList<Object>();	// パラメータ

		/**
		 * コンストラクタ.
		 * 
		 * @param piMessageID
		 *            メッセージID
		 * @param piText
		 *            置き換え文字
		 */
		public MessageInfo(String piMessageID, String[] piText) {
			this.messageID = piMessageID;

			for (int i = 0; i < piText.length; i++) {

				this.text.add(piText[i]);
			}
		}

		/**
		 * コンストラクタ.
		 * 
		 * @param piMessageID
		 *            メッセージID
		 * @param piText
		 *            置き換え文字
		 */
		public MessageInfo(String piMessageID, String piText) {
			this.messageID = piMessageID;
			this.text.add(piText);
		}

		/**
		 * コンストラクタ.
		 * 
		 * @param piMessageID
		 *            メッセージID
		 */
		public MessageInfo(String piMessageID) {
			this.messageID = piMessageID;
		}

		/**
		 * メッセージIDを取得.
		 * 
		 * @return メッセージID
		 */
		@SuppressWarnings("unused")
		public String getMessageID() {
			return this.messageID;
		}

		/**
		 * 文字列を取得.
		 * 
		 * @return 文字列
		 */
		public ArrayList<Object> getText() {
			return this.text;
		}

	}

}

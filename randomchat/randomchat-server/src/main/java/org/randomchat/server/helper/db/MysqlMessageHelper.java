package org.randomchat.server.helper.db;

import java.util.List;

import org.randomchat.common.listener.ImBindListener;
import org.randomchat.common.message.IMesssageHelper;
import org.randomchat.common.packets.ChatBody;
import org.randomchat.common.packets.UserMessageData;

/**
 * Mysql获取持久化+同步消息助手;
 * @author WChao
 * @date 2018年4月10日 下午4:06:26
 */
public class MysqlMessageHelper implements IMesssageHelper {

	@Override
	public ImBindListener getBindListener() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addGroupUser(String userid, String group_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<String> getGroupUsers(String group_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void writeMessage(String timelineTable, String timelineId, ChatBody chatBody) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeGroupUser(String userid, String group_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserMessageData getFriendsOfflineMessage(String userid, String from_userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserMessageData getFriendsOfflineMessage(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserMessageData getGroupOfflineMessage(String userid, String groupid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserMessageData getFriendHistoryMessage(String userid, String from_userid,Double beginTime,Double endTime,Integer offset,Integer count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserMessageData getGroupHistoryMessage(String userid, String groupid,Double beginTime,Double endTime,Integer offset,Integer count) {
		// TODO Auto-generated method stub
		return null;
	}


}

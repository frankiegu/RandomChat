package org.randomchat.common.listener;

import org.tio.core.ChannelContext;

/**
 * IM绑定用户及群组监听器;
 * @author Leo Yang
 * @date 2018年4月8日 下午4:09:14
 */
public interface ImBindListener {
	/**
	 * 绑定群组后回调该方法
	 * @param channelContext
	 * @param group
	 * @throws Exception
	 * @author Leo Yang
	 */
	void onAfterGroupBind(ChannelContext channelContext, String group) throws Exception;

	/**
	 * 解绑群组后回调该方法
	 * @param channelContext
	 * @param group
	 * @throws Exception
	 * @author tanyaowu
	 */
	void onAfterGroupUnbind(ChannelContext channelContext, String group) throws Exception;
	/**
	 * 绑定用户后回调该方法
	 * @param channelContext
	 * @param group
	 * @throws Exception
	 * @author Leo Yang
	 */
	void onAfterUserBind(ChannelContext channelContext, String userid) throws Exception;

	/**
	 * 解绑用户后回调该方法
	 * @param channelContext
	 * @param group
	 * @throws Exception
	 * @author tanyaowu
	 */
	void onAfterUserUnbind(ChannelContext channelContext, String userid) throws Exception;
}

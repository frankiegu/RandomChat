/**
 * 
 */
package org.randomchat.server;

import java.io.IOException;

import org.randomchat.server.handler.ImServerAioHandler;
import org.randomchat.server.helper.redis.RedisMessageHelper;
import org.randomchat.server.listener.ImGroupListener;
import org.randomchat.server.listener.ImServerAioListener;
import org.randomchat.common.ImConfig;
import org.tio.core.intf.GroupListener;
import org.tio.server.AioServer;

/**
 * 
 * @author Leo Yang
 *
 */
@SuppressWarnings("static-access")
public class ImServerStarter {
	
	private ImServerAioHandler imAioHandler = null;
	private ImServerAioListener imAioListener = null;
	private ImServerGroupContext imServerGroupContext = null;
	private ImGroupListener imGroupListener = null;
	private AioServer aioServer = null;
	private ImConfig imConfig = null;
	
	public ImServerStarter(ImConfig imConfig){
		this(imConfig,null);
	}
	
	public ImServerStarter(ImConfig imConfig,ImServerAioListener imAioListener){
		this.imConfig = imConfig;
		this.imAioListener = imAioListener;
		init();
	}
	
	public void init(){
		System.setProperty("tio.default.read.buffer.size", String.valueOf(imConfig.getReadBufferSize()));
		imAioHandler = new ImServerAioHandler() ;
		if(imAioListener == null){
			imAioListener = new ImServerAioListener();
		}
		GroupListener groupListener = imConfig.getImGroupListener();
		if(groupListener == null){
			imConfig.setImGroupListener(new ImGroupListener());
		}
		this.imGroupListener = (ImGroupListener)imConfig.getImGroupListener();
		imServerGroupContext = new ImServerGroupContext(imConfig,imAioHandler, imAioListener);
		imServerGroupContext.setGroupListener(imGroupListener);
		if(imConfig.getMessageHelper() == null){
			imConfig.setMessageHelper(new RedisMessageHelper());
		}
		aioServer = new AioServer(imServerGroupContext);
	}
	
	public void start() throws IOException {
		aioServer.start(this.imConfig.getBindIp(),this.imConfig.getBindPort());
	}
	
	public void stop(){
		aioServer.stop();
	}
}

/**
 * 
 */
package org.randomchat.server.command;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.tio.core.ChannelContext;
import org.randomchat.server.command.handler.processor.ProcessorIntf;
/**
 * 版本: [1.0]
 * 功能说明: 
 * 作者: Leo Yang 创建时间: 2017年9月11日 下午2:07:44
 */
public abstract class AbCmdHandler implements CmdHandlerIntf {
	
	//不同协议cmd处理命令如(ws、socket、自定义协议)握手、心跳命令等.
	protected Map<String,ProcessorIntf> processors = new HashMap<String,ProcessorIntf>();
	
	public AbCmdHandler addProcessor(ProcessorIntf processor){
		this.processors.put(processor.name(), processor);
		return this;
	}
	
	public ProcessorIntf getProcessor(ChannelContext channelContext){
		for(Entry<String,ProcessorIntf> processorEntry : processors.entrySet()){
			ProcessorIntf processor = processorEntry.getValue();
			if(processor.isProtocol(channelContext)){
				return processor;
			}
		}
		return null;
	}
	
	public ProcessorIntf getProcessor(String name){
		for(Entry<String,ProcessorIntf> processorEntry : processors.entrySet()){
			ProcessorIntf processor = processorEntry.getValue();
			if(name.equals(processor.name())){
				return processor;
			}
		}
		return null;
	}
	
	public ProcessorIntf removeProcessor(String name){
		
		return processors.remove(name);
	}
}

/**     
 * @文件名称: UserMapper.java  
 * @类路径: com.asiainfo.mapper  
 * @描述: TODO  
 * @作者：崔鹏 
 * @时间：2018年10月28日 上午9:06:06  
 * @版本：V1.0     
 */  
package com.asiainfo.mapper;

import com.asiainfo.entity.User;

/**
 * @author cuipeng
 * @email cuipeng3@asiainfo.com
 * @date 2018年10月28日 上午9:06:06
 * @version 1.0
 * @description 
 */
public interface UserMapper {

	public User getUser(int id);
}

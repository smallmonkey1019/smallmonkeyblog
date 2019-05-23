/**     
 * @文件名称: TestMybatis.java  
 * @类路径: mybatis  
 * @描述: TODO  
 * @作者：崔鹏 
 * @时间：2018年10月28日 上午9:08:52  
 * @版本：V1.0     
 */  
package mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.asiainfo.entity.User;

/**
 * @author cuipeng
 * @email cuipeng3@asiainfo.com
 * @date 2018年10月28日 上午9:08:52
 * @version 1.0
 * @description 
 */
public class TestMybatis {
	
	public static void main(String[] args) throws IOException {
		String resource = "mybatis.xml";
		//读取配置文件
		Reader reader = Resources.getResourceAsReader(resource);
		//获取会话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession openSession = sqlSessionFactory.openSession();
		//查询
		String sql = "com.asiainfo.mapper.UserMapper.getUser";
		//调用api查询
		User user = openSession.selectOne(sql,1);
		System.out.println(user.getId()+":"+user.getName());
	}

}

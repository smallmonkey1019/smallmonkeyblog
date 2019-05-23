/**     
 * @�ļ�����: TestMybatis.java  
 * @��·��: mybatis  
 * @����: TODO  
 * @���ߣ����� 
 * @ʱ�䣺2018��10��28�� ����9:08:52  
 * @�汾��V1.0     
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
 * @date 2018��10��28�� ����9:08:52
 * @version 1.0
 * @description 
 */
public class TestMybatis {
	
	public static void main(String[] args) throws IOException {
		String resource = "mybatis.xml";
		//��ȡ�����ļ�
		Reader reader = Resources.getResourceAsReader(resource);
		//��ȡ�Ự����
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession openSession = sqlSessionFactory.openSession();
		//��ѯ
		String sql = "com.asiainfo.mapper.UserMapper.getUser";
		//����api��ѯ
		User user = openSession.selectOne(sql,1);
		System.out.println(user.getId()+":"+user.getName());
	}

}

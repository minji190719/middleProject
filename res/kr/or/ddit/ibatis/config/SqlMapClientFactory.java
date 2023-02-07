package kr.or.ddit.ibatis.config;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SqlMapClientFactory {
    private static SqlMapClient smc;
    
    //초기화 블록
    static { 
        try {
            Charset charset = Charset.forName("UTF-8");
            Resources.setCharset(charset); 
            
            Reader rd = Resources.getResourceAsReader("kr/or/ddit/ibatis/config/sqlMapConfig.xml");
            
            //SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd); //이렇게 쓰면 smc는 지역변수가 됨.
            smc = SqlMapClientBuilder.buildSqlMapClient(rd);
            
            rd.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static SqlMapClient getSqlMapClient() { //싱글톤
        return smc;
    }
}

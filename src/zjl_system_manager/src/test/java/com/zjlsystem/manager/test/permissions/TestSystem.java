/**
 * @Title: TestSystem.java
 * @Package com.zjlsystem.manager.test.permissions
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:
 * 
 * @author zhujl
 * @date 2017年7月20日 下午7:35:20
 * @version V1.0
 */

package com.zjlsystem.manager.test.permissions;


 
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;  
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;  
import org.springframework.test.web.servlet.MockMvc;  
import org.springframework.transaction.annotation.Transactional;  
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;  
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;  
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;  
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;
import com.zjlsystem.entity.permissions.SystemButton;

/**
 * @ClassName: TestSystem
 * @Description: TODO
 * @author zhujl
 * @modify zhujl
 * @date 2017年7月20日 下午7:35:20
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:spring.xml" })
// 当然 你可以声明一个事务管理 每个单元测试都进行事务回滚 无论成功与否
@TransactionConfiguration(defaultRollback = true)
// 记得要在XML文件中声明事务哦~~~我是采用注解的方式
@Transactional
public class TestSystem {
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		// webAppContextSetup 注意上面的static import
		// webAppContextSetup 构造的WEB容器可以添加fileter 但是不能添加listenCLASS
		// WebApplicationContext context =
		// ContextLoader.getCurrentWebApplicationContext();
		// 如果控制器包含如上方法 则会报空指针
		this.mockMvc = webAppContextSetup(this.wac).build();
	}

	@Test
	// 有些单元测试你不希望回滚
	@Rollback(false)
	public void systemButtonInsert() throws Exception {
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String date=sdf.format(new Date());
//		SystemButton systemButton=new SystemButton();
//		systemButton.setId("1");
//		systemButton.setButtonMethod("add");
//		systemButton.setButtonName("添加");
//		systemButton.setCreateMan("zjl");
//		
//		systemButton.setCreateTime(date);
//		systemButton.setIcon("/images/icon.png");
//		systemButton.setModifyTime(date);
//		systemButton.setOrderNo(1);
//		systemButton.setRemarks("无");
//		
//		String requestJson=new Gson().toJson(systemButton);
//		
//		mockMvc.perform((post("/permissions/systembutton/insert.shtml").contentType(MediaType.APPLICATION_JSON).content(requestJson))).andExpect(status().isOk()).andDo(print());
	}
}

package test.model;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.yelong.core.jdbc.BaseDataBaseOperation;
import org.yelong.core.jdbc.sql.condition.support.Condition;
import org.yelong.core.model.service.SqlModelServiceAdapter;
import org.yelong.core.model.sql.SqlModel;

import com.labbol.demo.user.model.User;

/**
 * 仅供演示使用
 * 
 * @author PengFei
 */
public class ModelServiceDemo {

	// 这里无法构建LabbolModelService。因为LabbolModelService需要Mybatis。该接口为LabbolModelService的超接口，可以满足测试
	static SqlModelServiceAdapter modelService = ModelServiceSupplier.modelService;

	@Test
	public void findAll() {
		List<User> users = modelService.findAll(User.class);
		users.stream().map(User::getUsername).forEach(System.out::println);
	}

	@Test
	public void findBySqlModel_01() {
		SqlModel<User> sqlModel = new SqlModel<>();
		sqlModel.addCondition(new Condition("username", "=", "yelong"));
		List<User> users = modelService.findBySqlModel(User.class, sqlModel);
		users.stream().map(User::getUsername).forEach(System.out::println);
	}

	@Test
	public void findBySqlModel_02() {
		SqlModel<User> sqlModel = new SqlModel<>();
		sqlModel.addCondition(new Condition("username", "<>", "yelong"));
		List<User> users = modelService.findBySqlModel(User.class, sqlModel);
		users.stream().map(User::getUsername).forEach(System.out::println);
	}

	@Test
	public void findBySqlModel_03() {
		User sqlModel = new User();
		sqlModel.setUsername("yelong");
		sqlModel.addConditionOperator("username", "<>");
		sqlModel.addSortField("createTime", "desc");
		List<User> users = modelService.findBySqlModel(User.class, sqlModel);
		users.stream().map(User::getUsername).forEach(System.out::println);
	}

	@Test
	public void findFirstBySqlModel_01() {
		SqlModel<User> sqlModel = new SqlModel<>();
		sqlModel.addCondition("username", "=", "yelong");
		User user = modelService.findFirstBySqlModel(User.class, sqlModel);
		System.out.println(user.getUsername());
	}

	@Test
	public void findFirstBySqlModel_02() {
		User sqlModel = new User();
		sqlModel.setUsername("yelong");
		User user = modelService.findFirstBySqlModel(User.class, sqlModel);
		System.out.println(user.getUsername());
	}

	@Test
	public void findById() {
		User user = modelService.findById(User.class, "12345678912345789");
		System.out.println(user.getUsername());
	}

	@Test
	public void modifySelectiveById() {
		User user = new User();
		user.setId("12345678912345789");
		user.setState("1");
		boolean result = modelService.modifySelectiveById(user);
		System.out.println(result);
	}

	@Test
	public void removeById() {
		boolean result = modelService.removeById(User.class, "123456789123456789");
		System.out.println(result);
	}

	@Test
	public void daseDataBaseOperation_01() {
		BaseDataBaseOperation db = modelService.getBaseDataBaseOperation();
		Long count = db.count("select count(0) from co_user");
		System.out.println(count);
	}

}

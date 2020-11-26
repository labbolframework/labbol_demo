package test.model;

import org.yelong.core.jdbc.BaseDataBaseOperation;
import org.yelong.core.model.ModelConfiguration;
import org.yelong.core.model.convertor.ModelAndMapConvertor;
import org.yelong.core.model.service.JdbcModelService;
import org.yelong.core.model.service.SqlModelService;
import org.yelong.core.model.service.SqlModelServiceAdapter;
import org.yelong.spring.boot.test.YelongTestBeanFactory;
import org.yelong.spring.boot.test.YelongTestBeanFactorys;

/**
 * 仅供演示使用
 * 
 * @author PengFei
 */
public class ModelServiceSupplier {

	static SqlModelService sqlModelService = YelongTestBeanFactorys.buildModelService();

	static SqlModelServiceAdapter modelService;

	public static class SqlModelServiceAdapterImpl extends JdbcModelService implements SqlModelServiceAdapter {

		public SqlModelServiceAdapterImpl(ModelConfiguration modelConfiguration, BaseDataBaseOperation db) {
			super(modelConfiguration, db);
		}

		public SqlModelServiceAdapterImpl(ModelConfiguration modelConfiguration, BaseDataBaseOperation db,
				ModelAndMapConvertor modelAndMapConvertor) {
			super(modelConfiguration, db, modelAndMapConvertor);
		}

	}

	static {
		YelongTestBeanFactory yelongTestBeanFactory = new YelongTestBeanFactory();
		BaseDataBaseOperation baseDataBaseOperation = yelongTestBeanFactory.buildBaseDataBaseOperation();
		ModelConfiguration modelConfiguration = yelongTestBeanFactory.buildModelConfiguration();
		modelService = new SqlModelServiceAdapterImpl(modelConfiguration, baseDataBaseOperation);
	}

}

package com.lws.generator;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.lws.generator.constant.ModulEnum;
import com.lws.generator.util.DatasourcePropertiesUtils;

import java.io.File;

/**
 * 代码生成
 *
 * @author wilsonlee
 */
public class CodeGenerator {

    public static void main(String[] args) {
        //1、选择模块
        ModulEnum module = ModulEnum.AUTH;

        /** 全局配置 */
        GlobalConfig globalConfig = new GlobalConfig();
        //1、作者
        globalConfig.setAuthor("wilsonlee");
        //2、覆盖生成文件
        globalConfig.setFileOverride(false);
        //3、生成文件路径
        globalConfig.setOutputDir("D:\\workspace\\wilsonlee\\lws-project" + File.separator + module.getUrl() + "\\src\\main\\java");
        //4、主键类型
        globalConfig.setIdType(IdType.AUTO);
        //5、生成swagger2
        globalConfig.setSwagger2(true);

        /** 策略配置 */
        StrategyConfig strategyConfig = new StrategyConfig();
        //1、需要生成的表
        strategyConfig.setInclude("gov_user_info","gov_role_type");
        //2、实体命名策略 - 驼峰
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        //3、字段命名策略 - 驼峰
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        //4、lombok
        strategyConfig.setEntityLombokModel(true);
        //5、过滤表前缀
        strategyConfig.setTablePrefix("gov_");

        /** 包配置 */
        PackageConfig packageConfig = new PackageConfig();
        //1、模块名称
        packageConfig.setModuleName(module.getModuleName());
        //2、包名
        packageConfig.setParent(module.getPageageName());

        /** 数据库配置 */
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDriverName(DatasourcePropertiesUtils.getProperty("mysql.DriverName"));
        dataSourceConfig.setUrl(DatasourcePropertiesUtils.getProperty("mysql.Url"));
        dataSourceConfig.setUsername(DatasourcePropertiesUtils.getProperty("mysql.Username"));
        dataSourceConfig.setPassword(DatasourcePropertiesUtils.getProperty("mysql.Password"));

        /** 代码生成 */
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(globalConfig);
        autoGenerator.setStrategy(strategyConfig);
        autoGenerator.setPackageInfo(packageConfig);
        autoGenerator.setDataSource(dataSourceConfig);
        //Freemarker模板引擎
        autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());
        autoGenerator.execute();
    }

}

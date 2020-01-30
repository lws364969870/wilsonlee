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

        /** 策略配置 */
        StrategyConfig strategyConfig = new StrategyConfig();
        //1、需要生成的表
        strategyConfig.setInclude("user");
        //2、实体命名策略 - 驼峰
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        //3、字段命名策略 - 驼峰
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        //4、lombok
        strategyConfig.setEntityLombokModel(true);

        /** 包配置 */
        PackageConfig packageConfig = new PackageConfig();
        //1、模块名称
        packageConfig.setModuleName(module.getModuleName());
        //2、包
        packageConfig.setParent("com.lws");

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

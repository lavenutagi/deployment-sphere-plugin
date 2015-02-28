package com.epam.grandhackathon.deployment.sphere.plugin.metadata.persistence.dao;


import java.util.Collection;
import javax.inject.Inject;

import org.modelmapper.ModelMapper;
import jenkins.model.Jenkins;

import com.epam.grandhackathon.deployment.sphere.plugin.metadata.model.EnvironmentMetaData;
import com.google.common.collect.Lists;

public class EnvironmentDao {

    @Inject
//    private PersistenceService persistenceService;

//    private EntityManager entityManager;

    private ModelMapper modelMapper = new ModelMapper();


    public EnvironmentDao () {
        Jenkins.getInstance().getInjector().injectMembers(this);
//        try {
//            entityManager = persistenceService.getGlobalEntityManagerFactory().createEntityManager();
//        } catch (SQLException | IOException exc) {
//            throw new IllegalStateException("Unable to instantiate EntityManager for BuildMetadataDao", exc);
//        }
    }

    public Collection<EnvironmentMetaData> findAll () {

//        Query query = entityManager.createQuery("SELECT e FROM Environment e", Environment.class);
//
//        final Collection<Environment> environments = (Collection<Environment>) query.getResultList();
//        List<EnvironmentMetaData> environmentMetaDatas = Lists.newArrayList();
//        for (Environment environment : environments) {
//            modelMapper.map(environment, EnvironmentMetaData.class);
//        }

        EnvironmentMetaData production = new EnvironmentMetaData("Production");
        DeploymentMetaData prodDeploy1 = new DeploymentMetaData();
        prodDeploy1.setBuildVersion("123123123");
        prodDeploy1.setDeployedAt(DateFormatUtil.formatDate(DateTime.now()));
        prodDeploy1.setApplicationName("CQ");
        DeploymentMetaData prodDeploy2 = new DeploymentMetaData();
        prodDeploy2.setBuildVersion("1231231234");
        prodDeploy2.setDeployedAt(DateFormatUtil.formatDate(DateTime.now()));
        prodDeploy2.setApplicationName("Hybris");

        production.setIdentity(123123L);
        production.setDeployments(Lists.newArrayList(prodDeploy1, prodDeploy2));

        return Lists.newArrayList(production, new EnvironmentMetaData("QA"), new EnvironmentMetaData(
                "Staging"));
//        return environmentMetaDatas;
    }


}

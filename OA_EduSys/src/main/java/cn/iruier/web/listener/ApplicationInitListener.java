package cn.iruier.web.listener;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

public class ApplicationInitListener extends ContextLoaderListener {
    @Override
    public void contextInitialized(ServletContextEvent event) {
        super.contextInitialized(event);
        WebApplicationContext context = WebApplicationContextUtils.findWebApplicationContext(event.getServletContext());
        RepositoryService repositoryService = (RepositoryService) context.getBean("repositoryService");
        if (repositoryService.createDeploymentQuery().deploymentName("process_Apply").singleResult() == null) {
            Deployment deployment = repositoryService.createDeployment().name("process_Apply").addClasspathResource("apply.bpmn").deploy();
        }
    }
}

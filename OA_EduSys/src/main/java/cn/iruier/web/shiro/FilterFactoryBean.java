package cn.iruier.web.shiro;

import cn.iruier.entity.Menu;
import cn.iruier.entity.Role;
import cn.iruier.service.MenuService;
import org.apache.shiro.config.Ini;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.config.IniFilterChainResolverFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FilterFactoryBean extends ShiroFilterFactoryBean {

    @Autowired
    private MenuService service;

//    private String filterChainDefinitions;

    @Override
    public void setFilterChainDefinitions(String definitions) {
        Ini ini = new Ini();
        ini.load(definitions);
        Ini.Section section = ini.getSection(IniFilterChainResolverFactory.URLS);
        if (CollectionUtils.isEmpty(section)) {
            section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
        }
        List<Menu> menus = service.queryAll();

        for (Menu menu : menus) {
            StringBuffer buffer = new StringBuffer();
            buffer.append("roles[");
            for (Role role : menu.getRoles()) {
                buffer.append(role.getRole_id() + ",");
            }
            buffer.deleteCharAt(buffer.length() - 1);
            buffer.append("]");
            section.put(menu.getMenu_url(), buffer.toString());
        }
        section.put("/**", "authc");
        setFilterChainDefinitionMap(section);
    }
}

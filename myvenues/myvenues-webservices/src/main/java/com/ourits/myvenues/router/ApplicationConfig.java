package com.ourits.myvenues.router;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/router")
public class ApplicationConfig extends Application {
	public Set<Class<?>> getClasses() {
		return new HashSet<Class<?>>(Arrays.asList(MyvenuesRetrieveRouter.class, MyvenuesMaintenanceRouter.class));
	}
}

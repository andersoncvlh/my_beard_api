package com.mybeardapi.test.integration;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	TestBarbeariaResource.class,
	TestPermissaoResource.class,
	TestUsuarioResource.class,
	TestTokenResource.class
})
public class SuiteClassesIntegracao {

}

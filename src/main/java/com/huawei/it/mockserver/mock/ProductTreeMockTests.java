package com.huawei.it.mockserver.mock;

import org.mockserver.client.MockServerClient;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.matchers.MatchType;
import org.mockserver.model.HttpStatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.Header.header;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;
import static org.mockserver.model.JsonBody.json;

@Component
public class ProductTreeMockTests {

    private static final Logger logger = LoggerFactory.getLogger(ProductTreeMockTests.class);

    ClientAndServer mockServer = startClientAndServer(1080);

    @PostConstruct
    public void init(){
        logger.info("start");
        getProduct();
        getApplication();
        getService();
    }

    public void getProduct(){
        mockServer
                .when(
                        request()
                                .withMethod("POST")
                                .withPath("/msc/cmdb/v1/instances/product/query")
                                .withHeaders(
                                        header("Accept","application/json")
                                )
                                .withBody(json("{\"orderBy\":[],\"contentSelector\":[],\"condition\":{\"constraint\":[]}}",
                                        MatchType.STRICT))
                )
                .respond(
                        response()
                                .withStatusCode(HttpStatusCode.ACCEPTED_202.code())
                                .withHeaders(
                                        header("Content-Type", "application/json")
                                )
                                .withBody(json("{\"totalNum\":\"int\",\"pageSize\":\"int\",\"totalPageNo\":\"int\",\"currentPage\":\"int\",\"objList\":[{\"id\":1111111111,\"name\":\"product1\",\"hrn\":\"string\",\"className\":\"string\",\"status\":\"string\",\"parentId\":\"string\",\"fullName_cn\":\"string\",\"fullName_en\":\"string\"},{\"id\":222222222,\"name\":\"product1\",\"hrn\":\"string\",\"className\":\"string\",\"status\":\"string\",\"parentId\":\"string\",\"fullName_cn\":\"string\",\"fullName_en\":\"string\"}]}",
                                        MatchType.STRICT
                                ))
                );

    }

    public void getApplication(){
        mockServer
                .when(
                        request()
                                .withMethod("GET")
                                .withPath("/msc/cmdb/v1/instances/bizapplication/query")
                                .withHeaders(
                                        header("Accept","application/json")
                                )
                                .withBody(json("{\"condition\":{\"constraint\":[{\"simple\":{\"name\":\"productName\",\"operator\":\"equal\",\"value\":\"product1\"}}]}}" ,
                                        MatchType.STRICT))
                )
                .respond(
                        response()
                                .withStatusCode(HttpStatusCode.ACCEPTED_202.code())
                                .withHeaders(
                                        header("Content-Type", "application/json")
                                )
                                .withBody(json("{\"totalNum\":\"int\",\"pageSize\":\"int\",\"totalPageNo\":\"int\",\"currentPage\":\"int\",\"objList\":[{\"id\":11111111,\"name\":\"app111\",\"className\":\"string\",\"hrn\":\"string\",\"status\":\"string\",\"parentId\":\"string\",\"fullName_cn\":\"string\",\"fullName_en\":\"string\",\"appId\":\"app1\",\"productName\":\"product1\",\"subProductName\":\"string\"},{\"id\":22222222,\"name\":\"app222\",\"className\":\"string\",\"hrn\":\"string\",\"status\":\"string\",\"parentId\":\"string\",\"fullName_cn\":\"string\",\"fullName_en\":\"string\",\"appId\":\"app1\",\"productName\":\"product1\",\"subProductName\":\"string\"}]}",
                                        MatchType.STRICT
                                ))
                );

    }


    public void getService(){
        mockServer
                .when(
                        request()
                                .withMethod("POST")
                                .withPath("/msc/cmdb/v1/instances/bizservice/query")
                                .withHeaders(
                                        header("Accept","application/json")
                                )
                                .withBody(json("{\"condition\":{\"constraint\":[{\"simple\":{\"name\":\"appId\",\"operator\":\"equal\",\"value\":\"app1\"}}]}}" ,
                                        MatchType.STRICT))
                )
                .respond(
                        response()
                                .withStatusCode(HttpStatusCode.ACCEPTED_202.code())
                                .withHeaders(
                                        header("Content-Type", "application/json")
                                )
                                .withBody(json("{\"totalNum\":\"int\",\"pageSize\":\"int\",\"totalPageNo\":\"int\",\"currentPage\":\"int\",\"objList\":[{\"id\":\"swerwer1213\",\"name\":\"service1\",\"className\":\"string\",\"status\":\"string\",\"hrn\":\"string\",\"parentId\":\"string\",\"clusterType\":\"TomcatDocker\",\"appId\":\"app1\",\"deployClusterHrn\":\"string\",\"instanceNum\":123123,\"version\":\"v1\",\"deployEnv\":\"string\",\"deployUnitHrn\":\"string\",\"deployUnitType\":\"string\",\"deployUnitName\":\"string\"}]}",
                                        MatchType.STRICT
                                ))
                );

    }


}

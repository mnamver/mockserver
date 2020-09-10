package com.huawei.it.mockserver;

import org.junit.jupiter.api.Test;
import org.mockserver.client.MockServerClient;
import org.mockserver.matchers.MatchType;
import org.mockserver.model.HttpStatusCode;

import static org.mockserver.model.Header.header;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;
import static org.mockserver.model.JsonBody.json;


public class MockserverApplicationTests {


    @Test
    public void getProduct(){
        new MockServerClient("localhost", 1080)
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

    @Test
    public void getApplication(){
        new MockServerClient("localhost", 1080)
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


    @Test
    public void getService(){
        new MockServerClient("localhost", 1080)
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

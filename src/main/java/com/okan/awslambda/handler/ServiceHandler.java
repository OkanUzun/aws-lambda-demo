package com.okan.awslambda.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;

import java.util.Collections;
import java.util.Map;

public class ServiceHandler implements RequestHandler<Map<String, Object>, Map<String, Object>> {
    @Override
    public Map<String, Object> handleRequest(final Map map, final Context context) {
        final String json = new Gson().toJson(map);
        context.getLogger().log("Request: " + map);
        return Collections.singletonMap("message", String.format("Lambda Function is invoked with request: %s", json));
    }
}

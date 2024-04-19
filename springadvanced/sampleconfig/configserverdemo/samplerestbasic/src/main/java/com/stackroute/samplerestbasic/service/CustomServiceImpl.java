package com.stackroute.samplerestbasic.service;

import org.springframework.stereotype.Service;

@Service
public class CustomServiceImpl implements CustomService{
    @Override
    public String customLogic() {
        // Implement your custom logic here
        return "this datasource is customized";
    }
}

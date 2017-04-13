package com.yusuf.spring.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.yusuf.spring.pojo.Advert;

@Component
public class AdvertValidator implements Validator {

    @SuppressWarnings("rawtypes")
	public boolean supports(Class aClass)
    {
        return aClass.equals(Advert.class);
    }

    public void validate(Object obj, Errors errors)
    {
        Advert newAdvert = (Advert) obj;        
    }
}

package com.woniu.factory;

import java.util.ArrayList;
import java.util.List;

import com.woniu.commnonservice.ProviderService;
import com.woniu.entity.User;
import org.springframework.stereotype.Component;


import com.woniu.entity.Product;

import feign.hystrix.FallbackFactory;

@Component
public class ProviderServiceFactory implements FallbackFactory<ProviderService>{

	@Override
	public ProviderService create(Throwable cause) {
		// TODO Auto-generated method stub
		return new ProviderService() {

			@Override
			public List<User> findall() {
				// TODO Auto-generated method stub
				User u = new User();
				u.setAccount("sd");
				List<User> l = new ArrayList<>();
				l.add(u);
				return l;
			}
			
		};
	}

}

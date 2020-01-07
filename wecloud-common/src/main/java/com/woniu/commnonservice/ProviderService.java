package com.woniu.commnonservice;

import com.woniu.entity.Product;
import com.woniu.entity.User;
import com.woniu.factory.ProviderServiceFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@FeignClient(name="WONIU58-PROVIDER",fallbackFactory=ProviderServiceFactory.class)
public interface ProviderService {
	@RequestMapping("/find/all")
	List<User> findall();
}

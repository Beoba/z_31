package com.spc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spc.bean.Dept;
import com.spc.service.DeptService;

@RestController
public class DeptController {
	@Autowired
	private DeptService deptService;

	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public boolean add(@RequestBody Dept dept) {
		return deptService.add(dept);
	}

	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	public Dept get(@PathVariable("id") Long id) {
		return deptService.get(id);
	}

	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Dept> list() {
		return deptService.list();
	}

	@Autowired
	private DiscoveryClient discoveryClient;

	@ResponseBody
	@GetMapping("/provider/discovery")
	public Object discovery() {
		List<String> list = discoveryClient.getServices();
		System.out.println(list);
		List<ServiceInstance> insList = discoveryClient.getInstances("SPRINGCLOUD-DEPT");
		for (ServiceInstance si : insList) {
			System.out.println(si.getHost() + "," + si.getServiceId() + "," + si.getPort() + "," + si.getUri() + ","
					+ si.getMetadata());
		}
		return this.discoveryClient;
	}
}

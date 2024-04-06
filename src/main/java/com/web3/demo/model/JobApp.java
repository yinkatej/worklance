package com.web3.demo.model;

import org.springframework.web.multipart.MultipartFile;

public record JobApp(String service, String deadline, MultipartFile data, double payment) {
}

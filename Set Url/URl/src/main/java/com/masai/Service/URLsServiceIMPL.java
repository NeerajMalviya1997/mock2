package com.masai.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Dao.URLsDao;
import com.masai.model.URLs;

import net.bytebuddy.utility.RandomString;


@Service
public class URLsServiceIMPL implements URLsService {
	
	@Autowired
	private URLsDao dao;

	@Override
	public String createSorturl(String url) throws RuntimeException{
		Optional<URLs> p=dao.findByActualUrl(url);
		if(p.isPresent()) {
			throw new RuntimeException("url is already ragistered");
		}else {
		
		URLs urls=new URLs();
		String shrt=RandomString.make(6);
		urls.setShortUrl(shrt);
		urls.setActualUrl(url);
		urls.setExpiry(LocalDate.now().plusDays(7));
		urls.setUrlgenerateddate(LocalDate.now());
		dao.save(urls);
		
		
		return shrt;
		}
		
	}

	@Override
	public String getcustomurl(String shorturl) throws RuntimeException{
		Optional<URLs> p =dao.findByShortUrl(shorturl);
		if(p.isPresent()) {
			int v=LocalDate.now().compareTo(p.get().getExpiry());
			
			if(v>0) {
				throw new RuntimeException("url is expire");
				
			}else {
				return p.get().getActualUrl();
			}
				
			
			
		}else {
			throw new RuntimeException("url is incorrect");
		}
		
	}

}

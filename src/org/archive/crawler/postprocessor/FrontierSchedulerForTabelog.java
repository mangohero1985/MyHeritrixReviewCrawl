/**
 * 
 */
package org.archive.crawler.postprocessor;

import org.archive.crawler.datamodel.CandidateURI;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import sun.util.logging.resources.logging;

/**
 * @author mangohero1985
 * @create-time     Feb 4, 2013   4:28:13 PM   
 */
public class FrontierSchedulerForTabelog extends FrontierScheduler{
	
	private static final long  serialVersionUID = 1L;
	public FrontierSchedulerForTabelog(String name) {
		
		super(name);
	}
	protected void schedule(CandidateURI caUri) {
		
		String uri = caUri.toString();
		//只抓取包含固定字符的uri,控制抓取范围在www.tabelog.com域名下
	
//	    if((uri.contains("tabelog.com/aichi/A2301/A230101/")&&uri.contains("/dtlrvwlst/COND-0/smp2/")&&uri.contains("?rvw_part=all&PG="))||uri.contains("dns:tabelog.com")||uri.contains("http://tabelog.com/robots.txt")){
//	    	
//	    	//控制台输出当前的URI
//	    	System.out.println(uri);
//	    	getController().getFrontier().schedule(caUri);
//	    }
//		String reg = "^http://tabelog\\.com/aichi/A2301/A230101/(?!.*((kdwr)|(cat_lst)|(map)|(R)|(new_open)|(photo)|(rank)|(dtlmenu)|(dtlmobile)|(dtlratings)|(favoritelst))).*$";
//		if(uri.matches(reg)||uri.contains("dns:tabelog.com")||uri.contains("http://tabelog.com/robots.txt")){
//			System.out.println(uri);
//	    	getController().getFrontier().schedule(caUri);
//			
//		}
		
		if((uri.contains("tabelog.com/aichi/")&&uri.contains("/A230")&&uri.contains("/dtlrvwlst/COND-0/smp2/")&&uri.contains("&rvw_part=all")&&uri.contains("lc=0")&&uri.contains("PG="))||uri.contains("dns:tabelog.com")||uri.contains("http://tabelog.com/robots.txt")){
	    //if((uri.contains("tabelog.com/aichi/A2301/A230101/")&&uri.contains("/dtlrvwlst/COND-0/smp2/")&&uri.contains("?rvw_part=all&PG="))||uri.contains("dns:tabelog.com")||uri.contains("http://tabelog.com/robots.txt")){
	    	
	    	//控制台输出当前的URI
	    	System.out.println(uri);
    	    getController().getFrontier().schedule(caUri);
//	    	if(uri.contains("tabelog.com/aichi/A2301/A230101/")&&uri.contains("/dtlrvwlst/COND-0/smp2/")&&uri.contains("?rvw_part=all&PG=")){
//	    		System.out.println(uri);
//		    	getController().getFrontier().schedule(caUri);
//	    		
//	    	}
	    }
	}
	
}



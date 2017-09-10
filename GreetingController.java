package hello;


import java.util.ArrayList;
import java.util.Iterator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.datastax.driver.core.*;
import com.datastax.driver.core.policies.DCAwareRoundRobinPolicy;

import hello.MyResult;

@RestController

public class GreetingController {

    @RequestMapping("/A2")
    public ArrayList<MyResult> siwei(@RequestParam(value="cql", defaultValue="select * from a2final.crimedata where Dispatch_Time='8:30:00' allow filtering;") String cql) {
		    final Cluster.Builder clusterBuilder = Cluster.builder()
		    .addContactPoints(
		            "52.33.187.40", "52.25.115.214", "35.26.218.237" // AWS_VPC_US_WEST_2 (Amazon Web Services (VPC))
		    )
		    .withLoadBalancingPolicy(DCAwareRoundRobinPolicy.builder().withLocalDc("AWS_VPC_US_WEST_2").build()) // your local data centre
		    .withPort(9042)
		    .withAuthProvider(new PlainTextAuthProvider("iccassandra", "6c84d144aa9a84b58a50aebc9198df26"));
		ResultSet resultSet=null;
		ArrayList<MyResult> myResult = new ArrayList<MyResult>();
		Iterator<Row> iterator;
		try (final Cluster cluster = clusterBuilder.build()) {
		final Metadata metadata = cluster.getMetadata();
		System.out.printf("Connected to cluster: %s\n", metadata.getClusterName());
		
		Session session = cluster.connect();            
		String select = cql;
		resultSet = session.execute(select);
		iterator = resultSet.iterator();
		for(int i=0;i<100;i++){
		//while(iterator.hasNext()){
				Row row = iterator.next();
				myResult.add(new MyResult(row.getDate("dispatch_date"),row.getTime("dispatch_time"), row.getString("location_block"), row.getInt("dc_dist"), row.getDouble("dc_key"), row.getDouble("lat"), row.getDouble("lon"),row.getString("police_districts"), row.getString("psa"), row.getString("text_general_code"), row.getInt("ucr_general")));			
		}
		
		for (final Host host: metadata.getAllHosts()) {
		    System.out.printf("Datacenter: %s; Host: %s; Rack: %s\n", host.getDatacenter(), host.getAddress(), host.getRack());
		}
	 }
    return myResult;
    }
}

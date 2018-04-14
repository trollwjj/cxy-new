import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrDocument;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring/applicationContext-*.xml")
public class SorljTest {

    @Autowired
    private SolrServer solrServer;


    public void synAllData(){



    }

}

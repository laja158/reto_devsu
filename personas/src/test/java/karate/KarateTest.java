package karate;

import com.intuit.karate.junit5.Karate;
import com.intuit.karate.junit5.Karate.Test;

class KarateTest {
    
    @Test
    Karate testAll(){
        return Karate.run("classpath:karate").relativeTo(getClass());
    }
}

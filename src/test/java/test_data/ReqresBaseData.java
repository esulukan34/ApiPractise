package test_data;

import java.util.HashMap;
import java.util.Map;

public class ReqresBaseData {

    public Map<String,Object> expectedDataMethod(Integer id, String email, String first_name, String last_name, String avatar) {

        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("id", id);
        expectedData.put("email", email);
        expectedData.put("first_name", first_name);
        expectedData.put("last_name", last_name);
        expectedData.put("avatar", avatar);

        return expectedData;
    }

    //public Map<String,Object> expectedDataMethod2(Integer page,Integer per_page,Integer total,Integer total_pages,Map<String,Object> data){
//
    //    Map<Integer, Object> pageMap = new HashMap<>();
    //    pageMap.put(page,page);
    //    pageMap.put(per_page,per_page);
    //    pageMap.put(total,total);
    //    pageMap.put(total_pages,total_pages);
    //    pageMap.put(data,data);
//
    //    return pageMap;
    //}
}

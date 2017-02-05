package com.prits.backend.repo;

import com.prits.backend.vo.CustomerPageRequest;
import com.prits.backend.vo.SearchCriteria;


import java.util.List;

/**
 * Created by Pritesh Patel on 2/5/2017.
 */
public class CustomerQueryBuilder {

    /**
     * Build count query based on filter criteria. This result will be used by UI to decide if pagination
     * needs extra page links or not.
     *
     * @param request
     * @return
     */
    public static String getCustomerCountQuery(CustomerPageRequest request){
        SelectBuilder query = new SelectBuilder()
                .from("Customer")
                .column("count(*)");

        List<SearchCriteria> criteriaList = request.getFilters();
        for(SearchCriteria criteria  : criteriaList){
            String name = criteria.get_name();
            String value = criteria.get_value();

            //if(StringUtils.isNotBlank(name) && StringUtils.isNotBlank(value)){
            if(name != null && value != null && !name.trim().equalsIgnoreCase("") && !value.trim().equalsIgnoreCase("")){
                query.where(name.trim() + " LIKE '%"+ value.trim()+"%'");
            }
        }
        return query.toString();
    }

    /**
     * Builds search query with pagination for H2 db based on provided search criteria from client
     *
     * @param request
     * @return
     */
    public static String getCustomerSearchRequest(CustomerPageRequest request){
        SelectBuilder query = new SelectBuilder()
                .from("Customer")
                .column("*");
        List<SearchCriteria> criteriaList = request.getFilters();
        for(SearchCriteria criteria  : criteriaList){
            String name = criteria.get_name();
            String value = criteria.get_value();

            //if(StringUtils.isNotBlank(name) && StringUtils.isNotBlank(value)){
            if(name != null && value != null && !name.trim().equalsIgnoreCase("") && !value.trim().equalsIgnoreCase("")){
                query.where(name.trim() + " LIKE '%"+ value.trim()+"%'");
            }
        }
        if(request.get_sortField() != null  && request.get_sortOrder() != null){
            if(!request.get_sortOrder().equalsIgnoreCase("asc")) {
                query.orderBy(request.get_sortField() + " " + request.get_sortOrder());
            }
        }
        String q = query.toString();
        q = q + " limit " + request.get_offSet() +"," + request.get_size();
        return q;
    }
}

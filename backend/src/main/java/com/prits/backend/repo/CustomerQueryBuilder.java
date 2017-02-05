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
            String name = criteria.getName();
            String value = criteria.getValue();

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
            String name = criteria.getName();
            String value = criteria.getValue();

            //if(StringUtils.isNotBlank(name) && StringUtils.isNotBlank(value)){
            if(name != null && value != null && !name.trim().equalsIgnoreCase("") && !value.trim().equalsIgnoreCase("")){
                query.where(name.trim() + " LIKE '%"+ value.trim()+"%'");
            }
        }
        if(request.getSortField() != null  && request.getSortOrder() != null){
            if(!request.getSortOrder().equalsIgnoreCase("asc")) {
                query.orderBy(request.getSortField() + " " + request.getSortOrder());
            }
        }
        String q = query.toString();
        q = q + " limit " + request.getOffSet() +"," + request.getSize();
        return q;
    }
}

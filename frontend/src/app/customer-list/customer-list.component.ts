import { Component, OnInit } from '@angular/core';
import {CustomerSearchService} from "./customer-search.service";
import {CustomerSearchRequest} from "../model/customer.search.request.model";
import {SearchCriteria} from "../model/search.crtiteria.model";

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  private totalRows : number = 0;

  constructor(private searchService  :CustomerSearchService) { }

  ngOnInit() {
    let searchReq = new CustomerSearchRequest();
    searchReq.offSet = 0;
    searchReq.size = 10;
    searchReq.sortField = 'CUSTOMER_ID';
    searchReq.sortOrder = 'ASC';

    let criteria = new SearchCriteria();
    criteria.name = 'FIRST_NAME';
    criteria.value = 'James';

    //searchReq.filters[0] = criteria;

    console.log('Search Request : ', searchReq);

    this.searchService.searchCustomer(searchReq).subscribe(customerSearchResponse => {
          console.log('Processing response...', customerSearchResponse)
          //this.totalRecords = response.totalRows;
        },
        err => {
          // Log errors if any
          console.log(err);
        }
    );
  }

}

import { Component, OnInit } from '@angular/core';
import {CustomerSearchService} from "./customer-search.service";
import {CustomerSearchRequest} from "../model/customer.search.request.model";
import {SearchCriteria} from "../model/search.crtiteria.model";
import {Customer} from "../customer.model";
import {CustomerService} from "../customer.service";
import {Observable} from "rxjs";
import {CustomerSearchResponse} from "../model/customer-search-response.model";

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  private totalRows : number = 0;
  private customers : Customer[];

  constructor(private searchService  :CustomerSearchService,private custService : CustomerService) { }

  ngOnInit() {
    //this.page = event.first/event.rows;
    //this.getCustomers();
    this.searchCustomer();
  }

  getCustomers() {
    let fieldName : string = '';
    let fieldValue : string = '';
    console.log('Building request object');
    this.custService.getCustomers(0 , 10, 'CUSTOMER_ID', 'ASC',fieldName,fieldValue).subscribe(
        customers => {
          console.log('Loading cars from backend....')
          this.customers = customers;
        },
        err => {
          // Log errors if any
          console.log(err);
        }
    );
  }

  loadCustomersLazy(event){
    //this.searchCustomer(event);
  }

  searchCustomer(){
    console.log('Handling lazy load event...');
    let searchReq = new CustomerSearchRequest();
    searchReq._offSet = 0;
    searchReq._size = 10;
    searchReq._sortField = 'CUSTOMER_ID';
    searchReq._sortOrder = 'ASC';

    let criteria = new SearchCriteria();
    criteria._name = 'FIRST_NAME';
    criteria._value = 'James';

    //searchReq.filters[0] = criteria;

    console.log('Search Request : ', searchReq);

    this.searchService.searchCustomer(searchReq).subscribe(cRes => {
          console.log('Processing response...', cRes);
          this.totalRows = cRes._totalRows;
          this.customers = cRes._results;

        },
        err => {
          // Log errors if any
          console.log(err);
        }
    );
  }

}

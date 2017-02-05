import {Component, OnInit} from '@angular/core';
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

    private totalRows: number = 0;
    private customers: Customer[];

    constructor(private searchService: CustomerSearchService, private custService: CustomerService) {
    }

    ngOnInit() {

        //Prepare default request
        let searchReq = new CustomerSearchRequest();
        searchReq._offSet = 0;
        searchReq._size = 10;
        searchReq._sortField = 'CUSTOMER_ID';
        searchReq._sortOrder = 'ASC';
        this.searchCustomer(searchReq);
    }


    loadCustomersLazy(event) {
        //event.first = First row offset
        //event.rows = Number of rows per page
        //event.sortField = Field name to sort with
        //event.sortOrder = Sort order as number, 1 for asc and -1 for dec
        //filters: FilterMetadata object having field as key and filter value, filter matchMode as value

        let filterObj = event.filters;
        console.log('filter by : ', filterObj);
        console.log('firstName : ', filterObj['firstName']);
        let fieldName: string = '';
        let fieldValue: string = '';
        if (filterObj.hasOwnProperty('firstName')) {
            fieldName = 'FIRST_NAME';
            fieldValue = filterObj['firstName']['value'];
            console.log('Name : ', fieldName);
            console.log('Value : ', fieldValue);
        }

        let searchReq = new CustomerSearchRequest();
        searchReq._offSet = event.first;
        searchReq._size = event.rows;
        searchReq._sortField = 'CUSTOMER_ID';
        searchReq._sortOrder = (event.sortOrder === 1 ? 'ASC' : 'DESC');

        let criteria = new SearchCriteria();
        criteria._name = fieldName;
        criteria._value = fieldValue;
        searchReq._filters = [];
        searchReq._filters.push(criteria);
        this.searchCustomer(searchReq);
    }

    searchCustomer(sReq: CustomerSearchRequest) {
        console.log('Handling lazy load event...');
        console.log('Search Request : ', sReq);

        this.searchService.searchCustomer(sReq).subscribe(cRes => {
                console.log('Processing response...', cRes["totalRows"]);
                this.totalRows = cRes["totalRows"];
                this.customers = cRes["results"];

            },
            err => {
                // Log errors if any
                console.log(err);
            }
        );
    }

}

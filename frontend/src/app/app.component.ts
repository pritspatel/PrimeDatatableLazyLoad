import {Component, OnInit} from '@angular/core';
import {CustomerService} from "./customer.service";
import {Customer} from "./customer.model";
import {LazyLoadEvent, FilterMetadata} from "primeng/components/common/api";

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

    title = 'Prime NG Datatable Lazy Load Demo';
    private customers: Customer[];
    totalRecords: number;
    page: number;

    constructor(private custService: CustomerService) {
        custService.getTotalRecords().subscribe(count => {
                console.log('Getting total record counts....')
                this.totalRecords = count;
            },
            err => {
                // Log errors if any
                console.log(err);
            }
        );
    }

    loadCustomersLazy(event: LazyLoadEvent) {
        console.log('Firing lazy load event...');
        console.log('event.first : %d', event.first);
        console.log('Event : ', event);
        //in a real application, make a remote request to load data using state metadata from event
        //event.first = First row offset
        //event.rows = Number of rows per page
        //event.sortField = Field name to sort with
        //event.sortOrder = Sort order as number, 1 for asc and -1 for dec
        //filters: FilterMetadata object having field as key and filter value, filter matchMode as value


        //this.page = event.first/event.rows;
        let offSet = event.first;
        let orderBy = (event.sortOrder === 1 ? 'ASC' : 'DESC');
        let filterObj = event.filters;
        console.log('filter by : ', filterObj);
        console.log('firstName : ', filterObj['firstName']);
        let fieldName : string = '';
        let fieldValue : string = '';
        if(filterObj.hasOwnProperty('firstName')){
            fieldName = 'FIRST_NAME';
            fieldValue = filterObj['firstName']['value'];
            console.log('Name : ', fieldName);
            console.log('Value : ', fieldValue);
        }
        this.custService.getCustomers(offSet , event.rows, event.sortField, orderBy,fieldName,fieldValue).subscribe(
            customers => {
                console.log('Loading cars from backend....')
                this.customers = customers;
                //this.totalRecords = this.customers.length;
            },
            err => {
                // Log errors if any
                console.log(err);
            }
        );
    }

    ngOnInit(): void {
        this.page = 0;
    }
}

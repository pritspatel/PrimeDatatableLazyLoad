import {Component, OnInit} from '@angular/core';
import {CustomerService} from "./customer.service";
import {Customer} from "./customer.model";
import {LazyLoadEvent} from "primeng/components/common/api";

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
        //in a real application, make a remote request to load data using state metadata from event
        //event.first = First row offset
        //event.rows = Number of rows per page
        //event.sortField = Field name to sort with
        //event.sortOrder = Sort order as number, 1 for asc and -1 for dec
        //filters: FilterMetadata object having field as key and filter value, filter matchMode as value


        //this.page = event.first/event.rows;
        let offSet = event.first;
        this.custService.getCustomers(offSet , event.rows).subscribe(
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
        /*this.custService.getCustomers(0,10).subscribe(
            customers => {
                console.log('Loading cars from backend....');
                this.datasource = customers;
                this.totalRecords = this.datasource.length;
                this.customers = this.datasource.slice(0, 10);
                console.log('Loading cars from backend completed....');
            },
            err => {
                // Log errors if any
                console.log(err);
            }
        );*/
    }
}

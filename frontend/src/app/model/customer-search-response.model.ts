import {Customer} from "../customer.model";
export class CustomerSearchResponse{
    private totalRows : number;
    private results : Customer[];


    get _totalRows(): number {
        console.log('get totalRows :', this.totalRows);
        return this.totalRows;
    }

    set _totalRows(value: number) {
        console.log('set totalRows :', value);
        this.totalRows = value;
    }

    get _results(): Customer[] {
        return this.results;
    }

    set _results(value: Customer[]) {
        this.results = value;
    }
}
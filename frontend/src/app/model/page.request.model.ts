import {Filter} from "./filter.model";
export class PageRequest{

    private sortField : string;
    private sortOrder : string;
    private filters : Filter[];
    private offset  : number;
    private rows : number;
    constructor(){}


    get _sortField(): string {
        return this.sortField;
    }

    set _sortField(value: string) {
        this.sortField = value;
    }

    get _sortOrder(): string {
        return this.sortOrder;
    }

    set _sortOrder(value: string) {
        this.sortOrder = value;
    }

    get _filters(): Filter[] {
        return this.filters;
    }

    set _filters(value: Filter[]) {
        this.filters = value;
    }


    get _offset(): number {
        return this.offset;
    }

    set _offset(value: number) {
        this.offset = value;
    }

    get _rows(): number {
        return this.rows;
    }

    set _rows(value: number) {
        this.rows = value;
    }
}
import { NgLazyLoadPage } from './app.po';

describe('ng-lazy-load App', function() {
  let page: NgLazyLoadPage;

  beforeEach(() => {
    page = new NgLazyLoadPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});

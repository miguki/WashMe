import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AllServicePackagesComponent } from './all-service-packages.component';

describe('AllServicePackagesComponent', () => {
  let component: AllServicePackagesComponent;
  let fixture: ComponentFixture<AllServicePackagesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AllServicePackagesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AllServicePackagesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});

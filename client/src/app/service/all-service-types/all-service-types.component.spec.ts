import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AllServiceTypesComponent } from './all-service-types.component';

describe('AllServiceTypesComponent', () => {
  let component: AllServiceTypesComponent;
  let fixture: ComponentFixture<AllServiceTypesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AllServiceTypesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AllServiceTypesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HotelbookComponent } from './hotelbook.component';

describe('HotelbookComponent', () => {
  let component: HotelbookComponent;
  let fixture: ComponentFixture<HotelbookComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HotelbookComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HotelbookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

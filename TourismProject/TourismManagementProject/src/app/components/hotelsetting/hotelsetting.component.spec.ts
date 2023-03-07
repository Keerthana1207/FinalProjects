import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HotelsettingComponent } from './hotelsetting.component';

describe('HotelsettingComponent', () => {
  let component: HotelsettingComponent;
  let fixture: ComponentFixture<HotelsettingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HotelsettingComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HotelsettingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

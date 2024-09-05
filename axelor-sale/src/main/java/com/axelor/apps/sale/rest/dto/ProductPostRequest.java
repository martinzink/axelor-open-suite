package com.axelor.apps.sale.rest.dto;

import com.axelor.apps.base.db.Company;
import com.axelor.apps.base.db.Currency;
import com.axelor.apps.base.db.Partner;
import com.axelor.apps.base.db.Product;
import com.axelor.utils.api.ObjectFinder;
import com.axelor.utils.api.RequestPostStructure;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ProductPostRequest extends RequestPostStructure {

  @NotNull @NotEmpty private List<Long> productsId;

  private Long companyId;

  private Long partnerId;
  private Long currencyId;

  public void setPartnerId(Long partnerId) {
    this.partnerId = partnerId;
  }

  public Long getCurrencyId() {
    return currencyId;
  }

  public void setCurrencyId(Long currencyId) {
    this.currencyId = currencyId;
  }

  public void setProductsId(List<Long> productsId) {
    this.productsId = productsId;
  }

  public List<Long> getProductsId() {
    return productsId;
  }

  public Long getCompanyId() {
    return companyId;
  }

  public void setCompanyId(Long companyId) {
    this.companyId = companyId;
  }

  public Long getPartnerId() {
    return partnerId;
  }

  public List<Product> fetchProducts() {
    List<Product> products = new ArrayList<>();
    if (productsId.isEmpty()) {
      return null;
    }
    for (Long productId : productsId) {

      products.add(ObjectFinder.find(Product.class, productId, ObjectFinder.NO_VERSION));
    }
    return products;
  }

  public Company fetchCompany() {
    if (companyId == null || companyId == 0L) {
      return null;
    }
    return ObjectFinder.find(Company.class, companyId, ObjectFinder.NO_VERSION);
  }

  public Partner fetchPartner() {
    if (partnerId == null || partnerId == 0L) {
      return null;
    }
    return ObjectFinder.find(Partner.class, partnerId, ObjectFinder.NO_VERSION);
  }

  public Currency fetchCurrency() {
    if (currencyId == null || currencyId == 0L) {
      return null;
    }
    return ObjectFinder.find(Currency.class, currencyId, ObjectFinder.NO_VERSION);
  }
}
package services

import bao.ho.models.CurrencyInfo
import dao.{CurrencyDAO, CurrencyInfoDAO}
import javax.inject.{Inject, Singleton}

import scala.concurrent.Future

@Singleton
class CurrencyInfoServiceImpl @Inject()(currencyDao: CurrencyDAO,
                                        currencyInfoDAO: CurrencyInfoDAO) extends CurrencyInfoService(currencyInfoDAO) {
  override def getPrice(currency: String, from: Long, to: Long): Future[Seq[CurrencyInfo]] = {

    currencyInfoDAO.getPrice(1, from, to)
  }
}

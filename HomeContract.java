public interface HomeContract { 

    interface View extends BaseContract.View {
        void responseBanners(BannerBean bean);
        void responseNotice(BaseBean bean);
    }

    interface Presenter extends BaseContract.Presenter {
        void requestBanners(Params params);
        void requestNotice(Params params);
    }

    interface Model extends BaseContract.Model {
        Observable(BannerBean) requestBanners(Params params);
        Observable(BaseBean) requestNotice(Params params);
    }
}
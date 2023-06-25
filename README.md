# Java-Intern-task2

//post operation using file
 
 @PostMapping("/")
    public ResponseEntity<?> createBannerAds(@RequestParam("file") MultipartFile file, @RequestParam("banner") String banner) throws JsonProcessingException, JsonMappingException, JsonParseException, IOException {

        BannerImageAd banner1 = new ObjectMapper().readValue(banner, BannerImageAd.class);
        banner1.setCreatedDate(new Date());
/*
        boolean isExist = new File(servletContext.getRealPath("/banner_image/")).exists();
        if(!isExist) {
            new File(servletContext.getRealPath("/banner_image")).mkdir();
            System.out.println("made folder");
        }
*/
        //create folder if not created
        
        
        
        File f = new File(path);
        if (!f.exists()) {
            f.mkdir();
        }


        String filename = file.getOriginalFilename();
        //random name generate file
        String randomID = UUID.randomUUID().toString();
        String modifiedFileName = randomID.concat(filename.substring(filename.lastIndexOf(".")));

        String serverFile = path +File.separator+modifiedFileName;
        try {
            Files.copy(file.getInputStream(), Paths.get(serverFile));
        } catch (Exception e) {
            e.printStackTrace();
        }

        banner1.setImageName(modifiedFileName);

        BannerImageAd bannerImage  =  this.bannerImageAdService.addBannerImageAds(banner1);

      return  ResponseEntity.ok(bannerImage);
    }
